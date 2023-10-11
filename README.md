# Problemo - A library for solving problems

**Problemo was made to make error-handling more easier.**

Using many methods, you can cover many scenarios in your program.

Here a few examples:

```java
public Result<UUID> parseUUID(String uuidString) {
    
    if (uuidString == null) return Result.none();
    
    UUID uuid;
    try {
        uuid = UUID.fromString(uuidString);
    } catch (IllegalArgumentException exception) {
        return Result.problem(Problem.plain("Invalid uuid!")); // The string could be a translation key. Who knows...
    }
    
    return Result.some(uuid);
}
```

```java
public Result<User> getUser(UUID uuid) {

    if (uuid == null) return Result.problem(Problem.error(new NullPointerException("UUID param is null")));

    User user;
    try {
        user = requestUser(uuid);
    } catch (TimeoutException exception) {
        return Result.problem(Problem.unavailable("Database connection timed out."));
    }
 
    if (user == null) return Result.none();
        
    return Result.of(user);
}
```

