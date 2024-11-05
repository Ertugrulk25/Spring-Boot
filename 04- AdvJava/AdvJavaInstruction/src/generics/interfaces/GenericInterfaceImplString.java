package generics.interfaces;
//2.SEÇENEK:Generic interface i implemente ederken data tipine karar verebiliriz
public class GenericInterfaceImplString implements GenericInterface<String> {

    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }
}
