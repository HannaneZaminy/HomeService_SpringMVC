package ir.maktab.data.domain;

import ir.maktab.data.enums.ImageType;

import javax.persistence.*;

@Entity
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ImageType type = ImageType.PROFILE;

    @Lob
    private byte[] data;

    @ManyToOne
    private Specialist specialist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public ImageFile setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
