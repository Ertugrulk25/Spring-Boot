package com.Interview;

public class C01_InterviewQuestion {
    /*
    Spring Framework nedir? Avantajları nelerdir?
    Java'da uygulama geliştirilken Dependecy Injection yani bağımlılık enjeksiyonu
    birde objeleri kendi yoneticek şekilde olması durumudur

    bağımlılık yonetilmesi kolaylağı test edilebilirlik
    hibernate çeşitli entegrasyonlar eklenebilir
    restful servis desteği

GET /users          -> Tüm kullanıcıları getirir.
POST /users         -> Yeni bir kullanıcı oluşturur.
PUT /users/123      -> ID'si 123 olan kullanıcıyı günceller.
DELETE /users/123   -> ID'si 123 olan kullanıcıyı siler.


    Dependency Injection (DI) nedir? Spring'de nasıl uygulanır?
    Bağımlılık enjeksiyonu objenin ihtiyaç halinde verilmesi

@Component
public class SmsService implements MessageService{
    @Autowired//bağımlılığın enjekte edilmesini sağladım
    private Repository repo;


    Bean nedir? Spring'de bean yaşam döngüsü nasıldır?
    @Bean(build in classlardan obje olusturur)

    Bean ise Spring Container tarafından yönetilen nesneler
    Spring tarafından yönetilsin dediğimiz objeler

    tanımlama(@Component,@Bean)
    yaşam döngüsü belirlenir(@Scope(singelton,prototype))

    eğer singelton
    başlatılması(@PostConstructor)
    yok Etme(@PreDestroy)
    bu yapılar context yani spring tarafından yönetilir

    eğer prototype ise
    başlatılması(her istekte gerçekleştilir)
    yok Etme(Spring tarafından yönetilmez dev'in yok etmesi beklenir)


    Spring IoC Container nedir ve nasıl çalışır?
    Beanlerin yaşam döngülerini yönetir,bağımlılıklarını oluşturur
    Annotation ve Java config classlar ile


    Spring'de kullanılan temel anotasyonlar nelerdir?
    @Autowired : bağımlılıklari enjekte eder
    @Bean : Build yani hazihazırda önceden oluşturulmuş java classlarının objelerinin yonetimini spring'e bırakmayı sağlar
    @Component : kendi oluşturduğumuz objelerin yönetimi spring'e bırakmayı sağlar
    @Scope : Bean'in(Spring Objesinin)yaşam döngüsünü belirler
    @ComponentScan : Beanleri(spring objelerini)aramayi sağlar
    @Qualifier : birden fazla child bean olduğu durumlarda hangisinin enjekte olucagını belirler

    Spring Context Nedir?
    Spring tarafında yönetilen tüm objelerin icerisinde bulunduğu IoC Container

    IoC nedir?
    Inversion of Control
    kontrolun tersine cevrilmesi demek yani aslında
    Nesnelerin bağımlılıkları kendileri tarafından oluşturulurken
    bunu tersine cevirip dısarda almayı saglar


    @PostConstruct ve @PreDestroy Nedir?
    Bean var olduğunda bir methodun calısması anatasyondur : @PostConstructor

    Bean Yok edildiğinde bir methodun çalışmasını saglayan Anatasyondur : @PreDestroy

    @Configuration Nedir?
    XML yerine java kodu kullanarak konfigürasyon yapılmasını sağlar









     */



}
