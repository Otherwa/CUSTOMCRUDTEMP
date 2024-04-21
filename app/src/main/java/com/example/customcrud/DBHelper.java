package com.example.customcrud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        sqLiteDatabase = getWritableDatabase();
    }

    /**
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stmt = "CREATE TABLE " + "Courses" + " (" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME" + " TEXT," + "DURATION" + " TEXT," + "DESCRIPTION" + " TEXT" + ") ";
        sqLiteDatabase.execSQL(stmt);

        stmt = "CREATE TABLE " + "Student" + " (" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME" + " TEXT," + "ROLLNO" + " TEXT," + "DESCRIPTION" + " TEXT" + ") ";
        sqLiteDatabase.execSQL(stmt);

        stmt = "CREATE TABLE " + "Department" + " (" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME" + " TEXT," + "FLOOR" + " TEXT," + "DESCRIPTION" + " TEXT" + ") ";
        sqLiteDatabase.execSQL(stmt);


        // Insert dummy values for Courses table
        String insertStmt = "INSERT INTO Courses (NAME, DURATION, DESCRIPTION) VALUES ";
        insertStmt += "('Mathematics', '1 year', 'Introductory course on mathematics'), ";
        insertStmt += "('Physics', '2 years', 'Foundational course on physics'), ";
        insertStmt += "('Biology', '1.5 years', 'Basic biology course')";
        sqLiteDatabase.execSQL(insertStmt);

        // Insert dummy values for Student table
        insertStmt = "INSERT INTO Student (NAME, ROLLNO, DESCRIPTION) VALUES ";
        insertStmt += "('John Doe', 'A001', 'Student specializing in mathematics'), ";
        insertStmt += "('Jane Smith', 'A002', 'Student interested in physics'), ";
        insertStmt += "('Michael Johnson', 'A003', 'Student passionate about biology')";
        sqLiteDatabase.execSQL(insertStmt);

        // Insert dummy values for Department table
        insertStmt = "INSERT INTO Department (NAME, FLOOR, DESCRIPTION) VALUES ";
        insertStmt += "('Math Department', '3rd Floor', 'Department focused on mathematics'), ";
        insertStmt += "('Physics Department', '2nd Floor', 'Department specializing in physics'), ";
        insertStmt += "('Biology Department', '4th Floor', 'Department dedicated to biology')";
        sqLiteDatabase.execSQL(insertStmt);
    }


    public Cursor ViewData(String TABLE_NAME){
        String query = "SELECT * FROM " + TABLE_NAME;
        return sqLiteDatabase.rawQuery(query, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
