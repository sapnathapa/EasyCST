package bt.edu.cst.easycst;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import bt.edu.cst.easycst.ModuleDatabaseContract.ModuleDatabase;
import java.util.List;

public class ModuleDetailsAdapter extends RecyclerView.Adapter<ModuleDetailsAdapter.ModuleViewHolder> {
     private List<ModuleDetails> moduleDetailsList;
    private Context context;
    //int abscount=0;
    public RecyclerView rv;
    ModuleDatabaseHelper dbHelper;
    //List<ModuleDetails> moduleDetailsList;
    SQLiteDatabase db;
    private MyClickListener clickListener;

    public ModuleDetailsAdapter(List<ModuleDetails> moduleList, Attendance attendance, RecyclerView recyclerView) {
        this.context=attendance;
        moduleDetailsList = moduleList;
        rv=recyclerView;
    }
    @NonNull
    @Override
    public ModuleDetailsAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iteView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_modules, parent, false);

        /*context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.list_modules, parent, false);
        ModuleViewHolder viewHolder = new ModuleViewHolder(iteView);
        return viewHolder;*/
        return new ModuleDetailsAdapter.ModuleViewHolder(iteView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ModuleViewHolder holder, final int position) {
        final ModuleDetails moduleDetails = moduleDetailsList.get(position);
        int att=moduleDetails.getMattendance();
        String a = "Absent for "+att+" day(s)";
        holder.tvName.setText(moduleDetails.getMcode());
        holder.tvAddress.setText(moduleDetails.getMname());
        holder.tvPhone.setText(moduleDetails.getMtutor());
        holder.tvProfession.setText(a);
        //holder.tvProfession.setText("8");

        holder.plusbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final ModuleDetails moduleDetails = moduleDetailsList.get(position);
                final int moduleID = moduleDetails.getModuleID();
                dbHelper = new ModuleDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                int oldattendance=moduleDetails.getMattendance();
                int newattendance = ++ oldattendance;

                ContentValues values = new ContentValues();
                values.put("attendance", newattendance);

                db.update(ModuleDatabase.TABLE_NAME, values, ModuleDatabase._ID + " = " + moduleID, null );
                db.close();
                moduleDetails.setMattendance(newattendance);
                moduleDetailsList.set(position, moduleDetails);
                notifyDataSetChanged();
            }
        });

        holder.minusbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final ModuleDetails moduleDetails = moduleDetailsList.get(position);
                final int moduleID = moduleDetails.getModuleID();
                dbHelper = new ModuleDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                int oldattendance=moduleDetails.getMattendance();
                int newattendance = -- oldattendance;

                ContentValues values = new ContentValues();
                values.put("attendance", newattendance);

                db.update(ModuleDatabase.TABLE_NAME, values, ModuleDatabase._ID + " = " + moduleID, null );
                db.close();
                moduleDetails.setMattendance(newattendance);
                moduleDetailsList.set(position, moduleDetails);
                notifyDataSetChanged();
            }
        });

        holder.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModuleDetails userDetails = moduleDetailsList.get(position);
                final int moduleID = userDetails.getModuleID();
                dbHelper = new ModuleDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                PopupMenu menu = new PopupMenu(context, holder.ivMenu);

                menu.inflate(R.menu.card_menu);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.delete:
                                db.delete(ModuleDatabase.TABLE_NAME, ModuleDatabase._ID + " = " + moduleID, null);
                                notifyItemRangeChanged(position, moduleDetailsList.size());
                                moduleDetailsList.remove(position);
                                notifyItemRemoved(position);
                                db.close();
                                break;
                            case R.id.edit:
                                Intent intent = new Intent(context, UpdateModule.class);
                                intent.putExtra("MID", moduleID);
                                context.startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return moduleDetailsList.size();
    }


    public class ModuleViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvPhone, tvProfession;
        ImageButton ivMenu;
        Button plusbutton, minusbutton;
        MyClickListener listener;

        public ModuleViewHolder( @NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.mcoded);
            tvAddress = (TextView) itemView.findViewById(R.id.mnamed);
            tvPhone = (TextView) itemView.findViewById(R.id.mtutord);
            tvProfession = (TextView) itemView.findViewById(R.id.mabsentd);
            ivMenu = (ImageButton) itemView.findViewById(R.id.iv_menu);
            plusbutton = (Button) itemView.findViewById(R.id.absentplus);
            minusbutton = (Button) itemView.findViewById(R.id.absentminus);


        }
    }
    public interface MyClickListener {
        void onIncrement(View v, int position);
        void onDecrement(View v, int position);
    }
}
