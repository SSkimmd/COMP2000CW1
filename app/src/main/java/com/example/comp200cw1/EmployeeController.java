package com.example.comp200cw1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EmployeeController {
    public static ArrayList<Employee> Employees = new ArrayList<>();
    public static Employee CurrentUser;
    public static boolean CurrentUserValid;


    public static Employee GetEmployee(int id) {
        if(Employees == null) return null;

        for(int i = 0; i < Employees.size(); i++) {
            Employee employee = Employees.get(i);

            if(employee.ID == id) {
                return employee;
            }
        }

        return null;
    }

    public static Employee GetEmployee(String forename, String surname) {
        if(Employees == null) return null;

        for(int i = 0; i < Employees.size(); i++) {
            Employee employee = Employees.get(i);

            if(employee.Forename.equals(forename)) {
                if(employee.Surname.equals(surname)) {
                    return employee;
                }
            }
        }

        return null;
    }

    public static boolean Login(String forename, String surname) {
        if(CurrentUser != null) {
            if(CurrentUser.Forename.equals(forename)) {
                return false;
            }
        }

        Employee employee = GetEmployee(forename, surname);
        CurrentUserValid = employee != null;
        CurrentUser = employee;

        return CurrentUser != null;
    }

    public static boolean Logout() {
        CurrentUser = null;
        CurrentUserValid = false;

        return CurrentUser == null;
    }


    public static boolean CreateEmployee(String forename, String surname) {
        JSONObject newUser = new JSONObject();

        try {
            newUser.put("id", 9867);
            newUser.put("surname", surname);
            newUser.put("forename", forename);
        } catch(JSONException e) {
            e.printStackTrace();
            return false;
        }

        if(newUser.has("id")) {
            String url = "http://web.socem.plymouth.ac.uk/COMP2000/api/Employees";
            APIController.POSTEmployee(APIController.queue, url, newUser);
            return true;
        }

        return false;
    }

    public static boolean UpdateEmployee(int id, String forename, String surname) {
        JSONObject newUser = new JSONObject();

        try {
            newUser.put("id", id);
            newUser.put("surname", surname);
            newUser.put("forename", forename);
        } catch(JSONException e) {
            e.printStackTrace();
            return false;
        }

        if(newUser.has("id")) {
            String url = "http://web.socem.plymouth.ac.uk/COMP2000/api/Employees/" + id;
            APIController.PUTEmployee(APIController.queue, url, newUser);
            return true;
        }

        return false;
    }

    public static void UpdateEmployees(JSONArray employees) {
        if(employees == null) return;

        Employees.clear();

        for(int i = 0; i < employees.length(); i++) {
            try {
                JSONObject JSONEmployee = employees.getJSONObject(i);

                Employee employee = new Employee(
                        JSONEmployee.getInt("id"),
                        JSONEmployee.getString("forename"),
                        JSONEmployee.getString("surname")
                );

                Employees.add(employee);
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
