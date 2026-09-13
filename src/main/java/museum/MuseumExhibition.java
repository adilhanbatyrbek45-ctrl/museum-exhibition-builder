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

    private MuseumExhibition(Builder builder) {
        this.name = builder.name;
        this.theme = builder.theme;
        this.historicalPeriod = builder.historicalPeriod;
        this.exhibitCount = builder.exhibitCount;
        this.hallStyle = builder.hallStyle;
        this.audioGuide = builder.audioGuide;
        this.interactiveZone = builder.interactiveZone;
        this.virtualReality = builder.virtualReality;
        this.curator = builder.curator;
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

    public boolean isAudioGuide() {
        return audioGuide;
    }

    public boolean isInteractiveZone() {
        return interactiveZone;
    }

    public boolean isVirtualReality() {
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

    public static class Builder {

        private String name;
        private String theme;
        private String historicalPeriod;
        private int exhibitCount;
        private String hallStyle;
        private boolean audioGuide;
        private boolean interactiveZone;
        private boolean virtualReality;
        private String curator;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setTheme(String theme) {
            this.theme = theme;
            return this;
        }

        public Builder setHistoricalPeriod(String historicalPeriod) {
            this.historicalPeriod = historicalPeriod;
            return this;
        }

        public Builder setExhibitCount(int exhibitCount) {
            this.exhibitCount = exhibitCount;
            return this;
        }

        public Builder setHallStyle(String hallStyle) {
            this.hallStyle = hallStyle;
            return this;
        }

        public Builder setAudioGuide(boolean audioGuide) {
            this.audioGuide = audioGuide;
            return this;
        }

        public Builder setInteractiveZone(boolean interactiveZone) {
            this.interactiveZone = interactiveZone;
            return this;
        }

        public Builder setVirtualReality(boolean virtualReality) {
            this.virtualReality = virtualReality;
            return this;
        }

        public Builder setCurator(String curator) {
            this.curator = curator;
            return this;
        }

        public MuseumExhibition build() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Exhibition name is required");
            }

            if (theme == null || theme.isBlank()) {
                throw new IllegalStateException("Exhibition theme is required");
            }

            if (historicalPeriod == null || historicalPeriod.isBlank()) {
                throw new IllegalStateException("Historical period is required");
            }

            if (exhibitCount <= 0) {
                throw new IllegalStateException("Exhibit count must be greater than 0");
            }

            if (hallStyle == null || hallStyle.isBlank()) {
                throw new IllegalStateException("Hall style is required");
            }

            return new MuseumExhibition(this);
        }
    }
}