package cnc.cad.greendaoexample;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.greendaoexample
 * @class : ${CLASS_NAME}
 * @time : 2017/3/9 ${ITME}
 * @description :TODO
 */

@Entity(indexes = {
    @Index(value = "text, date DESC", unique = true)
})
public class Note {

    @Id
    private long id;
    @NotNull
    private String text;
    private String comment;
    private Date date;

    @Convert(converter = NodeTypeConverter.class, columnType = String.class)
    private NoteType type;


    public Note(){

    }

    public Note(Long id){
        this.id = id;
    }


    public Note(Long id, @NotNull String text, String comment, Date date, NoteType type){
        this.id = id;
        this.text = text;
        this.comment = comment;
        this.type = type;
    }

    @Generated(hash = 1439074888)
    public Note(long id, @NotNull String text, String comment, Date date, NoteType type) {
        this.id = id;
        this.text = text;
        this.comment = comment;
        this.date = date;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getText() {
        return text;
    }

    public void setText(@NotNull  String text) {
        this.text = text;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }
}
