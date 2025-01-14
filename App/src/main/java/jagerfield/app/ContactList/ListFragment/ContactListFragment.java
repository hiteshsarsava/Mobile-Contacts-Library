package jagerfield.app.ContactList.ListFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hitesh.mobilecontactslibrary.R;

import java.util.ArrayList;

import jagerfield.app.ContactView.DisplayContactActivity;
import jagerfield.app.Utilities.C;
import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.ImportContactsAsync;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class ContactListFragment extends Fragment {
    private ContactListFragment contactListFragment;
    private RecyclerView recyclerView;

    public ContactListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            contactListFragment = this;

            new ImportContactsAsync(getActivity(), new ImportContactsAsync.ICallback() {
                @Override
                public void mobileContacts(ArrayList<Contact> contactList) {
                    ArrayList<Contact> listItem = contactList;

                    if (listItem == null) {
                        listItem = new ArrayList<Contact>();
                        Log.i(C.TAG_LIB, "Error in retrieving contacts");
                    }

                    if (listItem.isEmpty()) {
                        Toast.makeText(getActivity(), "No contacts found", Toast.LENGTH_LONG).show();
                    }

                    recyclerView.setAdapter(new ContactListViewAdapter(contactListFragment, listItem));
                }
            }).execute();
        }
        return view;
    }


    /**
     * Fragment Contact List Adapter
     */
    private class ContactListViewAdapter extends RecyclerView.Adapter<ContactListViewAdapter.ViewHolder>
    {

        private ContactListFragment fragment;
        private Context context;
        private ArrayList<Contact> contactList = new ArrayList<>();

        public ContactListViewAdapter(ContactListFragment fragment, ArrayList<Contact> contactList) {
            this.fragment = fragment;
            context = fragment.getActivity();
            this.contactList = contactList;
        }

        @Override
        public ContactListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_contact_list_item, parent, false);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final ContactListViewAdapter.ViewHolder holder, int position) {

            holder.vhContact = contactList.get(holder.getBindingAdapterPosition());
            holder.name.setText(holder.vhContact.getFirstName() + " " + holder.vhContact.getLastName());

            String imageUri = contactList.get(holder.getBindingAdapterPosition()).getPhotoUri();
            Glide.with(context)
                    .load(imageUri)
                    .error(R.drawable.person)
                    .transform(new CropCircleTransformation(context))
                    .into(holder.image);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (contactList == null) {
                        return;
                    }

                    Intent i = new Intent(context, DisplayContactActivity.class);

                    GsonBuilder builder = new GsonBuilder();
                    builder.excludeFieldsWithoutExposeAnnotation();
                    Gson gsonBuilder = builder.create();
                    String jsonContact = gsonBuilder.toJson(contactList.get(holder.getBindingAdapterPosition()));
                    i.putExtra(C.CONTACT, jsonContact);
                    context.startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView name;
            public final ImageView image;
            public Contact vhContact;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                name = (TextView) view.findViewById(R.id.tv_name);
                image = (ImageView) view.findViewById(R.id.iv_contact_Image);
            }

        }
    }


}
