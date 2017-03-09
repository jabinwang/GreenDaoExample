package cnc.cad.greendaoexample;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.greendaoexample
 * @class : ${CLASS_NAME}
 * @time : 2017/3/9 ${ITME}
 * @description :TODO
 */
public class NodeTypeConverter implements PropertyConverter<NoteType, String> {

    @Override
    public NoteType convertToEntityProperty(String databaseValue) {
        return NoteType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(NoteType entityProperty) {
        return null;
    }
}
