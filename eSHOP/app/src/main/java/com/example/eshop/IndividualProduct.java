package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class IndividualProduct extends AppCompatActivity {

    Spinner  Size;
    ArrayAdapter<String> arrayAdapter;
    String values[]={"Select","Small","Medium","Large"};

    ImageView SetImage;
    TextView NAME,PRICE,ProductQuantity,TotalAmount;
    ImageButton Add,Reduce;

    Button ADD_TO_CART;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_product);

        // choose Product Size

        Size=findViewById(R.id.size);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,values);
        Size.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();



        // set product details

        SetImage=findViewById(R.id.setImage);
        NAME=findViewById(R.id.name);
        PRICE=findViewById(R.id.price);
        ProductQuantity=findViewById(R.id.autoIncrement);
        TotalAmount=findViewById(R.id.overAllTotal);

        Add = findViewById(R.id.increment);
        Reduce=findViewById(R.id.decrement);

        Intent intent=getIntent();
        NAME.setText(intent.getStringExtra("StoreProductName"));
        PRICE.setText(intent.getStringExtra("StorePrice"));

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){

            int resid=bundle.getInt("image");
            SetImage.setImageResource(resid);
        }

        // calculate Total

        TotalAmount.setText(PRICE.getText().toString());

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Get=ProductQuantity.getText().toString();
                int addIncrement=Integer.parseInt(Get);

                String total=PRICE.getText().toString();
                int StoreTotal=Integer.parseInt(total);

                addIncrement++;

                int sum=addIncrement*StoreTotal;

                ProductQuantity.setText(String.valueOf(addIncrement));
                TotalAmount.setText(String.valueOf(sum));


            }
        });

        Reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Get=ProductQuantity.getText().toString();
                int Decrement=Integer.parseInt(Get);

                Decrement--;

                if (Decrement<=0){
                    Toast.makeText(IndividualProduct.this,"Kindly select the minimum of one quantity to purchase your products", Toast.LENGTH_SHORT).show();
                    ProductQuantity.setText("1");
                }else{
                    ProductQuantity.setText(String.valueOf(Decrement));

                    String total=TotalAmount.getText().toString();
                    int StoreTotal=Integer.parseInt(total);

                    String GivenPrize=PRICE.getText().toString();
                    int DefaultTotal=Integer.parseInt(GivenPrize);

                    int sum=StoreTotal-DefaultTotal;
                    TotalAmount.setText(String.valueOf(sum));

                }
            }
        });


        ADD_TO_CART=findViewById(R.id.cart);
        ADD_TO_CART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String ProductName=NAME.getText().toString();
                String ProductPrice=PRICE.getText().toString();
                String ProductSize=Size.getSelectedItem().toString();
                String Quantity=ProductQuantity.getText().toString();
                String Total=TotalAmount.getText().toString();

                Intent intent=new Intent(getApplicationContext(),ConfirmAndPay.class);
                intent.putExtra("ProductName",ProductName);
                intent.putExtra("ProductPrice",ProductPrice);
                intent.putExtra("ProductSize",ProductSize);
                intent.putExtra("Quantity",Quantity);
                intent.putExtra("Total",Total);
                startActivity(intent);


            }
        });

    }
}