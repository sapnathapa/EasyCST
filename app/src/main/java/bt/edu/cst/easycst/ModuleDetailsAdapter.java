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
    List<ModuleDetails> moduleDetailsList;
    Context context;
    ModuleDatabaseHelper dbHelper;
    //List<ModuleDetails> moduleDetailsList;
    SQLiteDatabase db;

    public ModuleDetailsAdapter(List<ModuleDetails> moduleDetailsList) {
        this.moduleDetailsList = moduleDetailsList;
    }

    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.list_modules, parent, false);
        ModuleViewHolder viewHolder = new ModuleViewHolder(iteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ModuleViewHolder holder, final int position) {
        ModuleDetails moduleDetails = moduleDetailsList.get(position);
        int att=moduleDetails.getMattendance();
        String a = "Absent for "+att+" day(s)";
        holder.tvName.setText(moduleDetails.getMcode());
        holder.tvAddress.setText(moduleDetails.getMname());
        holder.tvPhone.setText(moduleDetails.getMtutor());
        holder.tvProfession.setText(a);
        //holder.tvProfession.setText("8");

        holder.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ModuleDetails userDetails = moduleDetailsList.get(position);
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
        holder.plusbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final ModuleDetails userDetails = moduleDetailsList.get(position);
                final int moduleID = userDetails.getModuleID();
                dbHelper = new ModuleDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                int oldattendance=userDetails.getMattendance();
                int attendance = ++ oldattendance;

                ContentValues values = new ContentValues();
                values.put("attendance", attendance);

                db.update(ModuleDatabase.TABLE_NAME, values, ModuleDatabase._ID + " = " + moduleID, null );
                notifyDataSetChanged();
                db.close();
            }
        });
        holder.minusbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final ModuleDetails userDetails = moduleDetailsList.get(position);
                final int moduleID = userDetails.getModuleID();
                dbHelper = new ModuleDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                int oldattendance=userDetails.getMattendance();
                int attendance = --oldattendance;

                ContentValues values = new ContentValues();
                values.put("attendance", attendance);

                db.update(ModuleDatabase.TABLE_NAME, values, ModuleDatabase._ID + " = " + moduleID, null );
                db.close();
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

        public ModuleViewHolder(View itemView) {
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
}
