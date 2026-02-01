package threadsbasic.immutable;

import java.util.*;

public final class ImmutableClass {
    private  int id;
    private final String name;
    private final Map<String, String> map;
    private  final List<String> contacts;
    private Date date;



    public ImmutableClass(int id, String name, Map<String, String> map, List<String> contacts, Date date) {
        this.id = id;
        this.name = name;
        this.map = new HashMap<>(map);
        this.contacts = new ArrayList<>(contacts);
        this.date = new Date(date.getTime());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return Collections.unmodifiableMap(new HashMap<>(map));
    }

    public List<String> getContacts() {
        return Collections.unmodifiableList(new ArrayList<>(contacts));
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", map=" + map +
                ", contacts=" + contacts +
                ", date=" + date +
                '}';
    }
}
