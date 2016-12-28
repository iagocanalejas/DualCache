[![Travis Build](https://travis-ci.org/bluelinelabs/LoganSquare.svg)](https://travis-ci.org/bluelinelabs/LoganSquare)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.fasterxml.jackson.core/jackson-databind/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.fasterxml.jackson.core/jackson-databind)

# Serializer example using [LoganSquare](https://github.com/bluelinelabs/LoganSquare)

```ruby
dependencies {
    apt 'com.bluelinelabs:logansquare-compiler:<VERSION>'
    compile 'com.bluelinelabs:logansquare:<VERSION>'
}
```

```java
public class LoganSquareSerializer<T> implements CacheSerializer<T> {

    private final Class<T> mClazz;

    public LoganSquareSerializer(Class<T> clazz){
        this.mClazz = clazz;
    }

    @Override
    public T fromString(String data) {
        return LoganSquare.parse(data, mClazz);
    }

    @Override
    public String toString(T object) {
        return LoganSquare.serialize(object);
    }

}
```