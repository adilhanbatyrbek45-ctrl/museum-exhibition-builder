package museum;

public class MuseumExhibition {

    private final String name;
    private final String theme;
    private final String historicalPeriod;
    private final int exhibitCount;
    private final String hallStyle;
    private final boolean audioGuide;
    private final boolean interactiveZone;
    private final boolean virtualReality;
    private final String curator;

    public MuseumExhibition(String name, String theme, String historicalPeriod,
                            int exhibitCount, String hallStyle, boolean audioGuide,
                            boolean interactiveZone, boolean virtualReality, String curator) {
        this.name = name;
        this.theme = theme;
        this.historicalPeriod = historicalPeriod;
        this.exhibitCount = exhibitCount;
        this.hallStyle = hallStyle;
        this.audioGuide = audioGuide;
        this.interactiveZone = interactiveZone;
        this.virtualReality = virtualReality;
        this.curator = curator;
    }

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public int getExhibitCount() {
        return exhibitCount;
    }

    public String getHallStyle() {
        return hallStyle;
    }

    public boolean hasAudioGuide() {
        return audioGuide;
    }

    public boolean hasInteractiveZone() {
        return interactiveZone;
    }

    public boolean hasVirtualReality() {
        return virtualReality;
    }

    public String getCurator() {
        return curator;
    }

    @Override
    public String toString() {
        return "MuseumExhibition{" +
                "name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", historicalPeriod='" + historicalPeriod + '\'' +
                ", exhibitCount=" + exhibitCount +
                ", hallStyle='" + hallStyle + '\'' +
                ", audioGuide=" + audioGuide +
                ", interactiveZone=" + interactiveZone +
                ", virtualReality=" + virtualReality +
                ", curator='" + curator + '\'' +
                '}';
    }
}