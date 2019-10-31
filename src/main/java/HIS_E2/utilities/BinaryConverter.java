package HIS_E2.utilities;
import org.bson.types.Binary;
import org.springframework.core.convert.converter.Converter;

public class BinaryConverter implements Converter<Binary, byte[]> {
public byte[] convert(Binary source)

{ return source.getData(); }

public Binary convertToBinary(byte[] a){
return new Binary(a);}

}