package customer.barcode.barcodewebx.converors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import customer.barcode.barcodewebx.productdatabasemodels.Company;
import customer.barcode.barcodewebx.productdatabasemodels.Image;

public class companyconvertor {


    @TypeConverter
    public static List<Company> stringToSomeObjectList(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Company>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Image> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }
}