package test.com.lapsa.kz;

import com.lapsa.kz.country.KZCity;

public class KZCityMessagesBundleTest extends EnumTypeMessagesBundleTest<KZCity> {

    @Override
    protected KZCity[] getAllEnumValues() {
	return KZCity.values();
    }
}
