public final class Attachment {
    private final String filename;

    public Attachment(String filename, long bytes) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "filename='" + filename + '\'' +
                '}';
    }
}

