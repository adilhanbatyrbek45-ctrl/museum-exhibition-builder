package museum;

public class Main {

    public static void main(String[] args) {

        ExhibitionDirector director = new ExhibitionDirector();

        MuseumExhibition historical = director.createHistoricalExhibition();
        MuseumExhibition art = director.createArtExhibition();
        MuseumExhibition science = director.createScienceExhibition();

        System.out.println(historical);
        System.out.println(art);
        System.out.println(science);

        MuseumExhibition customExhibition = new MuseumExhibition.Builder()
                .setName("Space Exploration")
                .setTheme("Science")
                .setHistoricalPeriod("20th - 21st Century")
                .setExhibitCount(30)
                .setHallStyle("Modern")
                .setAudioGuide(true)
                .setInteractiveZone(true)
                .setVirtualReality(true)
                .setCurator("Science Department")
                .build();

        System.out.println(customExhibition);
    }
}
