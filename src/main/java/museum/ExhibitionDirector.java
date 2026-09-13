package museum;

public class ExhibitionDirector {

    public MuseumExhibition createHistoricalExhibition() {
        return new MuseumExhibition.Builder()
                .setName("Ancient Egypt")
                .setTheme("History")
                .setHistoricalPeriod("3000 BC - 30 BC")
                .setExhibitCount(20)
                .setHallStyle("Classic")
                .setAudioGuide(true)
                .setInteractiveZone(false)
                .setVirtualReality(false)
                .setCurator("History Department")
                .build();
    }

    public MuseumExhibition createArtExhibition() {
        return new MuseumExhibition.Builder()
                .setName("Modern Art")
                .setTheme("Art")
                .setHistoricalPeriod("20th - 21st Century")
                .setExhibitCount(25)
                .setHallStyle("Modern")
                .setAudioGuide(true)
                .setInteractiveZone(true)
                .setVirtualReality(false)
                .setCurator("Art Department")
                .build();
    }

    public MuseumExhibition createScienceExhibition() {
        return new MuseumExhibition.Builder()
                .setName("Space Exploration")
                .setTheme("Science")
                .setHistoricalPeriod("20th - 21st Century")
                .setExhibitCount(30)
                .setHallStyle("Interactive")
                .setAudioGuide(true)
                .setInteractiveZone(true)
                .setVirtualReality(true)
                .setCurator("Science Department")
                .build();
    }
}
