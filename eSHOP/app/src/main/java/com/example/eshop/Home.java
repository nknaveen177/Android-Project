package com.example.eshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity {


    ImageView imageView;
    LoginDBHelper DB;

    //for gallery

    Gallery gallery;
    HomeGalleryAdapter homeGalleryAdapter;
    ImageView SelectedView;
    int images[]={
            R.drawable.defaultshopback,
            R.drawable.shirt,
            R.drawable.tshirt,
            R.drawable.tshirtthree,
            R.drawable.tshirttwo,
            R.drawable.saree,
            R.drawable.womenswear,
            R.drawable.moniter,
            R.drawable.cycle,
            R.drawable.cricketbat,
            R.drawable.shoe,
            R.drawable.bag
    };

    Toast toast;
    Button ChooseProduct;


    // Navigation bar

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    TextView ORDERED_DETAILS;

    OrdersDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        DB=new LoginDBHelper(this);

        dbHelper=new OrdersDBHelper(this);


        imageView=findViewById(R.id.homeLogo);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(Home.this, "Created by Naveen", Toast.LENGTH_SHORT).show();
            }
        });


        //for gallery

        gallery = (Gallery) findViewById(R.id.languagesGallery);
        SelectedView = (ImageView) findViewById(R.id.imageView);

        SelectedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toast= Toast.makeText(getApplicationContext(), "Would you like to buy the selected products \n   Click on the button below to get.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,1,1);
                toast.show();
            }
        });
        homeGalleryAdapter = new HomeGalleryAdapter(getApplicationContext(), images);
        gallery.setAdapter(homeGalleryAdapter);

        gallery.setOnItemClickListener((parent, view, position, id) -> {

            SelectedView.setImageResource(images[position]);
        });

        ChooseProduct=findViewById(R.id.chooseProduct);

        ChooseProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                startActivity(intent);
            }
        });


        // Navigation bar

        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawerFormation);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView=findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.user:
                        Intent intent=getIntent();
                        String userName=intent.getStringExtra("username");
                        Toast.makeText(Home.this, userName, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.home:
                        Toast.makeText(Home.this, "Already you stay in your home page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.products:
                        Intent intent1=new Intent(getApplicationContext(),ProductDetails.class);
                        startActivity(intent1);
                        break;
                    case R.id.share:

                        // sharing options

                        Intent Share=new Intent(android.content.Intent.ACTION_SEND);
                        Share.setType("text/plain");
                        Share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        Share.putExtra(Intent.EXTRA_SUBJECT,"Hi, This is my eSHOP Application ");
                        Share.putExtra(Intent.EXTRA_TEXT,"Would you want to this application please contact nknaveen177@gmail.com ."+getApplicationContext().getPackageName());
                        startActivity(Intent.createChooser(Share,"Sharing to.."));


                        break;
                    case R.id.feedback:
                        Intent intent3=new Intent(getApplicationContext(),FeedbackWindow.class);
                        startActivity(intent3);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(getApplicationContext(),PopupLogin.class);
                        startActivity(intent2);
                        break;

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ORDERED_DETAILS=findViewById(R.id.orderDetails);
        ORDERED_DETAILS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor=dbHelper.getOrderedData();
                if(cursor.getCount()==0){
                    Toast.makeText(getApplicationContext(),"No Order from eSHOP",Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer=new StringBuffer();

                buffer.append("Order Count :"+cursor.getCount()+"\n");
                buffer.append("\n");

                while(cursor.moveToNext()){
                    buffer.append("Product_ID : "+cursor.getString(0)+"\n");
                    buffer.append("User_NAME : "+cursor.getString(1)+"\n");
                    buffer.append("User_PHONE : "+cursor.getString(2)+"\n");
                    buffer.append("Product_NAME : "+cursor.getString(3)+"\n");
                    buffer.append("Product_PRICE : "+cursor.getString(4)+"\n");
                    buffer.append("Product_SIZE : "+cursor.getString(5)+"\n");
                    buffer.append("Product_QUANTITY : "+cursor.getString(6)+"\n");
                    buffer.append("Total AMOUNT : "+cursor.getString(7)+"\n");
                    buffer.append("User_ADDRESS : "+cursor.getString(8)+"\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder=new AlertDialog.Builder(Home.this);
                builder.setCancelable(true);
                builder.setTitle("User Purchased Entries:");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });



    }

}