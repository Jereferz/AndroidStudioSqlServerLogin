package com.example.logiiiinulti

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConexionSql {
    private val ip = "10.50.220.124:60000"
    private val db = "Escuelita"
    private val username = "usr_db"
    private val password = "pass_db"

    fun dbConn(): Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn: Connection? = null
        val connString: String
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"

            conn = DriverManager.getConnection(connString)
        } catch (ex: SQLException) {

            Log.e("Error: ", ex.message!!)
        } catch (ex1: ClassNotFoundException) {
            Log.e("Error: ", ex1.message!!)
        } catch (ex2: Exception) {
            Log.e("Error: ", ex2.message!!)
        }
        return conn
    }
}