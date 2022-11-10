package utilities;

import java.util.HashMap;
import java.util.Map;

public class ReqresInTestData {

    public Map<String,String> expectedDataMethod(String name, String jop){

        Map<String ,String> expectedDataMap = new HashMap<>();
        expectedDataMap.put("name",name);
        expectedDataMap.put("jop",jop);


        return expectedDataMap;
    }


}

