package app;

import io.cucumber.java.en.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SignIntest {


    String userName;
    String password;
    String role;
    ArrayList<Users> usersList = new ArrayList<Users>();
    Users user;



    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
    }



    @When("the user enter one of the following user name and password regardless his role")
    public void the_user_enter_one_of_the_following_user_name_and_password_regardless_his_role(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        for (int i = 0; i < rows.size(); i++) {
            Users addUser;
            if (rows.get(i).get(2).equals("Admin"))
                addUser = new Admin(rows.get(i).get(0), rows.get(i).get(1),rows.get(i).get(2),rows.get(i).get(3), rows.get(i).get(4));
            else if (rows.get(i).get(2).equals("Worker"))
                addUser = new Worker(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2),rows.get(i).get(3),rows.get(i).get(4));
            else if (rows.get(i).get(2).equals("Customer"))
                addUser = new Customer(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2),rows.get(i).get(3),rows.get(i).get(4));
            else
                addUser = new Secretary(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2),rows.get(i).get(3),rows.get(i).get(4));
            usersList.add(addUser);
        }
    }

    @Given("That the {string} is not signed in")
    public void that_the_is_not_signed_in(String string) {
        for (int i = 0; i < usersList.size(); i++)
            assertFalse(usersList.get(0).isSignedIn());
    }

    @Given("the {string} username is {string}")
    public void the_username_is(String string, String string2) {
        this.userName = userName;
        this.role = role;

    }

    @Given("the {string} password is {string}")
    public void the_password_is(String string, String string2) {
        this.password = password;
    }

    @Then("the {string} sign in succeeds")
    public void the_sign_in_succeeds(String string) {
        for (int i = 0; i < usersList.size(); i++)
            if (usersList.get(i).checkRole(role))
                assertTrue(usersList.get(i).signIn(userName, password));
    }

    @Then("the {string} is signed in")
    public void the_is_signed_in(String string) {
        for (int i = 0; i < usersList.size(); i++)
            if (usersList.get(i).checkRole(role)) {
                assertTrue(usersList.get(i).isSignedIn());
                if (role.equals("Admin")) {
                    user = new Admin(userName, password,"0595642327", "Tulkrem",role);
                    assertEquals(true, usersList.get(i).equals(user));
                }
                else if (role.equals("Worker")) {
                    user = new Worker(userName, password,"0595642328","Nubles", role);
                    assertEquals(true, usersList.get(i).equals(user));
                }
                else if (role.equals("Secretary")) {
                    user = new Secretary(userName, password,"0595642324","Ramallah", role);
                    assertEquals(true, usersList.get(i).equals(user));
                }
            }
    }

    @Then("go to {string} page")
    public void go_to_page(String string) {
    }

    @Then("the {string} sign in not succeeds")
    public void the_sign_in_not_succeeds(String string) {
        for (int i = 0; i < usersList.size(); i++)
            if (usersList.get(i).checkRole(role))
                assertFalse(usersList.get(i).signIn(userName, password));
    }

    @Then("the {string} is not signed in")
    public void the_is_not_signed_in(String string) {
        for (int i = 0; i < usersList.size(); i++)
            if (usersList.get(i).checkRole(role)) {
                assertFalse(usersList.get(i).isSignedIn());
                if (role.equals("Admin")) {
                    user = new Admin(userName, password,"0595642327", "Tulkrem", role);
                    assertEquals(false, usersList.get(i).equals(user));
                }
                else if (role.equals("Worker")) {
                    user = new Worker(userName, password,"0595642328","Nubles", role);
                    assertEquals(false, usersList.get(i).equals(user));
                }
                else if (role.equals("Secretary")) {
                    user = new Secretary(userName, password,"0595642324","Ramallah", role);
                    assertEquals(false, usersList.get(i).equals(user));
                }
            }
    }

}
