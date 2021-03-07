package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式：是一种行为设计模式：能让你减少对象之间混乱无序的依赖关系。
 * 该模式会限制对象直接的直接交互，迫使他们通过一个中介者对象进行合作。
 * 网状结构 转换为 星状结构
 * 优点：减少交互
 * 缺点：中介者对象比较复杂，包含其他对象的交互细节。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Agency agency = new Agency();

        Person boy = new Person("boy", 22, 20, 1, agency);

        Person girl1 = new Person("girl1", 20, 20, 0, agency);
        Person girl2 = new Person("girl2", 19, 20, 0, agency);
        Person girl3 = new Person("girl3", 18, 20, 0, agency);

        agency.register(boy);
        agency.register(girl1);
        agency.register(girl2);
        agency.register(girl3);

        agency.pair(boy);
    }
}

/**
 * 中介者
 */
interface Mediator {
    void register(Person person);
    void pair(Person person);
}

class Agency implements Mediator {
    List<Person> people = new ArrayList<>();

    @Override
    public void register(Person person) {
        people.add(person);
    }

    @Override
    public void pair(Person person) {
        for (Person p :
                people) {
            if(p.age == person.regAge && p.sex != person.sex){
                System.out.println(p.name + " marry " + person.name);
            }
        }
    }
}

class Person {
    String name;
    int age;
    int regAge;
    int sex;
    Agency agency;

    public Person(String name, int age, int regAge, int sex, Agency agency) {
        this.name = name;
        this.age = age;
        this.regAge = regAge;
        this.sex = sex;
        this.agency = agency;
    }

    public void findPartner(Person person) {
        agency.pair(this);
    }
}


