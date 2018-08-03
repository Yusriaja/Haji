package com.example.manasatpc.haji;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ManasatPC on 01/08/18.
 */

public class TaskContract {
    public TaskContract(){

    }


    /**
     * Inner class that defines constant values for the Store database table.
     * Each entry in the table represents a single item .
     */
    public final static class HAjiEntry implements BaseColumns {
        //Name of database table for Store
        public final static String TABLE_HAJI_MASTER = "master";
        public final static String TABLE__HAJI_HESTORICAL= "hestorical";
        public final static String TABLE__HAJI_REATING= "reating";
        public final static String TABLE__COMPANY_LOCATIONS= "company_location";
        public final static String TABLE__HAJI_LOST= "lost";
        public final static String TABLE__HAJI_POSITIONS= "positions";
        public final static String TABLE__HAJI_EASY_COMMUNICATE= "easy_communicate";
        public final static String TABLE__HAJI_PARTIIES= "parties";
        public final static String TABLE__HAJI_LOCATION_RATTTING= "location_ratting";

        public final static String TABLE__HAJI_PLACES= "places";
        public final static String TABLE__HAJI_PLACES_DETAILS = "places_details";
        public final static String TABLE__HAJI_PLACES_RATING ="places_rating";
        public final static String TABLE__HAJI_COMPANIES ="companies";
        public final static String TABLE__HAJI_LOCATIONS ="locations";
        public final static String TABLE__LANGUAGES ="language";

        public final static String TABLE__SETTINGS ="settings";

        public final static String TABLE__DETAILS ="details";

        public final static String TABLE__VOIES_TEXT ="voies_text";



        //Columns the table @TABLE_HAJI_MASTER
        //id unique
        public final static String ID_HAJI_MASTER = BaseColumns._ID;
        //id PASPORD
        public final static String HAJI_SEQ = "HAJI_SEQ";
        //id PASPORD
        public final static String HAJI_PASSPORD = "HAJI_PASSPORD";

        //name product
        public final static String FIRST_NAME = "first_name";
        //quantity
        public final static String LAST_NAME = "last_name";
        //supplierName
        public final static String PASSWORD = "password";
        //SupplierPhone Number
        public final static String EMAIL = "email";
        public final static String PHONE_MASTER = "phone_master";

        public final static String USER_ADMIN = "user_admin";



        //Columns the table @TABLE__HAJI_REATING
        public final static String _ID_HAJI_REATING = BaseColumns._ID;
        public final static String HAJI_RATTINIG_RATE ="haji_ratting_rate";
        public final static String HAJI_RATTING_DATE= "haji_ratting_date";
        public final static String HAJI_RATTING_COMMENTS = "haji_ratting_comments";





        //Columns the table @TABLE__HAJI_HESTORICAL
        public final static String _ID_HAJI_HESTORICAL = BaseColumns._ID;
        public final static String HAJI_HESTORICAL_DATE ="haji_hestorical_date";
        public final static String HAJI_HESTORICAL_TIME = "haji_hestorical_time";
        public final static String HAJI_HESTORICAL_DESCRIPTION = "haji_hestorical_description";


        //Columns the table @TABLE__COMPANY_LOCATIONS
        //id unique
        public final static String _ID_COMPANY_LOCATIONS = BaseColumns._ID;
        public final static String COMPANY_LOCATIONS_ID = "company_id";
        public final static String LOCATIONS_NAME = "locations_name";
        public final static String LOCATIONS_CORDONATE_LAN = "locations_cordonate_lan";
        public final static String LOCATIONS_CORDONATE_LAG = "locations_cordonate_lag";


        //Columns the table @TABLE__HAJI_LOST
        public final static String ID_LOST = BaseColumns._ID;
        public final static String HAJI_LOST_LOCATION_LAN = "haji_lost_locations_lan";
        public final static String HAJI_LOST_LOCATION_LAG = "haji_lost_locations_lag";
        public final static String HAJI_DATE_LOST = "date_lost";



        //Columns the table @TABLE__HAJI_POSITIONS
        public final static String ID_POSITIONS = BaseColumns._ID;
        public final static String HAJI_POSITIONS_LAN = "haji_positions_lan";
        public final static String HAJI_POSITIONS_LAG = "haji_positions_lag";
        public final static String HAJI__ID_LANGUAGE = "haji_language";
        public final static String ID_VOICE_TEXT = "id_voice_text";



        //Columns the table @TABLE__HAJI_LOCATIONS
        public final static String _ID_HAJI_LOCATIONS = BaseColumns._ID;
        public final static String _ID_HAJI = "id_haji";
        public final static String _ID_COMPANIES = "id_companies";

        //Columns the table @TABLE__HAJI_EASY_COMMUNICATE
        public final static String ID_HAJI_EASY_COMMUNICATE = BaseColumns._ID;
        public final static String HAJI_EASY_COMMUNICATE_TEXT_VOICE = "haji_easy_communicate_text_voice";
        public final static String HAJI_EASY_COMMUNICATE_DATE = "haji_easy_communicate_date";
/*
        //Columns the table @TABLE__HAJI_PLACES
        public final static String ID_HAJI_PALCES = BaseColumns._ID;
        public final static String HAJI_PALCES_NAME = "haji_palces_name";
        public final static String HAJI_PALCES_LOCATION_LAN = "haji_location_lan";
        public final static String HAJI_PALCES_LOCATION_LAG = "haji_location_lag";

        //Columns the table @TABLE__HAJI_PLACES_DETAILS
        public final static String _ID_HAJI_DETAILS = BaseColumns._ID;
        public final static String _ID_HAJI_PALCES = "haji_palces";
        public final static String _ID_HAJI_PALCES_MAIN_DETAILS = "haji_palces_main_details";




        //Columns the table @TABLE__HAJI_PLACES_RATING
        public final static String ID_HAJI_PLACES_RATING = BaseColumns._ID;
        public final static String HAJI_PLACE_ID = "place_id";
        public final static String HAJI_PLACE_DATE = "date";
        public final static String HAJI_PLACE_BILL_NUMBER = "bill_number";
        public final static String HAJI_PLACE_RATE = "haji_place_rate";
        public final static String HAJI_PLACE_RATE_REASON = "haji_place_rate_reason";
*/

        //Columns the table @TABLE__LANGUAGES
        public final static String _ID_LANGUAGE = BaseColumns._ID;
        public final static String LANGUAGE = "language";

        //Columns the table @TABLE__HAJI_COMPANIES
        //id unique
        public final static String ID_HAJI_COMPANIES = BaseColumns._ID;
        //السجل التجاري
        public final static String COMMERCIAL_REQISTER = "commercial_register";
        public final static String PHONE_COMPANIES = "phone_companies";
        public final static String SPONSIPOL_NAME = "sponsepol_name";
        public final static String COMPANY_ADDRESS = "company_address";

        //Columns the table @TABLE__VOIES_TEXT
        public final static String _ID = BaseColumns._ID;
        public final static String VOICE_TEXT = "voice_text";

/*
        //Columns the table @TABLE__MAIN_DETAILS
        public final static String ID_MAIN_DETAILS = BaseColumns._ID;
        public final static String MAIN_DETAILES = "main_details";
*/
        //Columns the table @TABLE__HAJI_PARTIES
        public final static String _ID_PART = BaseColumns._ID;
        public final static String PART_NAME = "part_name";


        //Columns the table @TABLE__HAJI_LOCATION_RATTTING
        public final static String ID_LOCATION_RATTTING = BaseColumns._ID;
        public final static String LOCATION_RATTTING_COMMENT = "location_ratting_comment";
        public final static String LOCATION_RATTTING_DATE = "location_ratting_date";
        public final static String LOCATION_RATTTING_ID_CORDENATE = "location_ratting_id_cordenate";




    }
    }
