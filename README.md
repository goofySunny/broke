## Notes
Database Connectivity includes the url to the database usually written as a string like jdbc:sqlite:{address}
the url is used in the DriverManager.getConnection({url_here}) function that returns a Connection object from the java.sql package. now that we have a Connection Object going we can close it by calling {connection_variable_name}.close().
too soon though. In order to execute queries we have to create a Statement and initialize it using the connection object like so :
Statement stmt = connection.createStatement();
now we are allowed to use stmt.executeUpdate({SQL_QUERY_GOES_HERE}).
if we are expecting a response we can do stmt.executeQuery({SQL_BLA_BLA_BLA}) and capture the return type into a variable of type ResultSet like so :
ResultSet result = stmt.executeQuery({YOU_KNOW_THE_DRILL}) and you can access each row by using while loop like so :
while (result.next()) {
    System.out.println(result.getInt({NAME_OF_COLUMN}))
    // or other data types
} 

## References