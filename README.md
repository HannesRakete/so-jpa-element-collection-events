# JPA @ElementCollection Event Test

Goal was to find any suitable event to consume when a collection annotated with @ElementCollection is changed, but the parent is not.

See: https://stackoverflow.com/q/65117091/1844850

## Result

There is no event in the given case, that the @ElementCollection is updated, but the parent entity is not, see:
* https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
* https://github.com/eclipse-ee4j/jpa-api/issues/167

### Workaround 1
Add a @Version for optimistic locking on the parent entity.

### Workaround 2
Migrate to another association-type, see https://thorben-janssen.com/hibernate-tips-query-elementcollection/

