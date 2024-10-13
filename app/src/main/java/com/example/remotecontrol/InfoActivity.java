package com.example.remotecontrol;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoActivity extends AppCompatActivity {

    ListView coordies_list, dev_list, ui_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        coordies_list = findViewById(R.id.coordies_list);
        dev_list = findViewById(R.id.appdev_list);
        ui_list = findViewById(R.id.ui_list);

        String[] name = new String[]{"Anmol Jain (Y22)", "Arunil Jain (Y22)", "Hardik Agarwal (Y22)"};
        String[] mobileno = new String[]{"7017283915", "9755345705", "9511544462"};
        String[] emailid = new String[]{"22uec017@lnmiit.ac.in", "22ume005@lnmiit.ac.in", "22uec045@lnmiit.ac.in"};
        add_data_to_list(name, mobileno, emailid, coordies_list);


        name = new String[]{"Ekagra Shandilya (Y22)", "Mudit Choudhary (Y23)"};
        mobileno = new String[]{"8709569920", "9672467580"};
        emailid = new String[]{"22uec043@lnmiit.ac.in", "23ucc623@lnmiit.ac.in"};
        add_data_to_list(name, mobileno, emailid, dev_list);



        name = new String[]{"Utkrasht Gupta (Y23)", "Anushka Jain (Y24)"};
        mobileno = new String[]{"9696915209", "8302257499"};
        emailid = new String[]{"23ucc608@lnmiit.ac.in", "24UCS267@lnmiit.ac.in"};
        add_data_to_list(name, mobileno, emailid, ui_list);


        findViewById(R.id.about_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void add_data_to_list(String[] name, String[] mobileno, String[] emailid, ListView lst) {
        people_info_adapter adapter = new people_info_adapter(InfoActivity.this, name, mobileno, emailid);
        lst.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnChildren(lst);
    }

    public class people_info_adapter extends ArrayAdapter<String> {
        String[] mName;
        String[] mMobileno;
        String[] mEmailid;
        Context mContext;

        public people_info_adapter(Context context, String[] arName, String[] arMobileno, String[] arEmailid) {
            super(context, R.layout.person_card_contactinfo, R.id.personname, arName);

            mName = arName;
            mMobileno = arMobileno;
            mEmailid = arEmailid;
            mContext = context;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder_person_info vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.person_card_contactinfo, parent, false);

                vholder = new VHolder_person_info(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder_person_info) row.getTag();
            }


            vholder.txtName.setText(mName[position]);

            vholder.phone_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + mMobileno[position]));
                    startActivity(intent);
                }
            });

            vholder.mail_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + mEmailid[position]));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(intent);
                }
            });

            return row;
        }
    }

    public class VHolder_person_info {
        TextView txtName;
        ImageView phone_img, mail_img;

        public VHolder_person_info(View r) {
            txtName = r.findViewById(R.id.personname);
            phone_img = r.findViewById(R.id.call_img);
            mail_img = r.findViewById(R.id.mail_img);
        }

    }
}