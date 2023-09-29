# Problemo - Eine Library um Probleme zu lösen

**Problemo ist dafür da, Error-Handling einfacher zu machen.**

Mithilfe vieler Methoden kannst du viele Szenarios in deinem Programm abdecken.

Hier ein paar Beispiele:

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

