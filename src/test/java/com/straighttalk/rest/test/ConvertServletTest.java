package com.straighttalk.rest.test;

import com.straighttalk.rest.Convert;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import javax.ws.rs.core.Application;
import static org.junit.Assert.assertEquals;


public class ConvertServletTest extends JerseyTest {

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(Convert.class);
    }

    @Test
    public void testNumbersToWords(){
        String output = target("/convert/numbersToWords")
                .queryParam("numToConv", "12")
                .queryParam("languageToConv", "en_us")
                .request()
                .get(String.class);
        JSONObject j = new JSONObject(output);

        assertEquals("Should return twelve", "twelve", j.getString("conversion"));
    }

    @Test
    public void testGetLocaleList(){
        String output = target("/convert/localeList")
                .request()
                .get(String.class);
        JSONArray j = new JSONArray(output);
        JSONArray expected = new JSONArray("[\"\",\"ar_AE\",\"ar_JO\",\"ar_SY\",\"hr_HR\",\"fr_BE\",\"es_PA\",\"mt_MT\",\"es_VE\",\"bg\",\"zh_TW\",\"it\",\"ko\",\"uk\",\"lv\",\"da_DK\",\"es_PR\",\"vi_VN\",\"en_US\",\"sr_ME\",\"sv_SE\",\"es_BO\",\"en_SG\",\"ar_BH\",\"pt\",\"ar_SA\",\"sk\",\"ar_YE\",\"hi_IN\",\"ga\",\"en_MT\",\"fi_FI\",\"et\",\"sv\",\"cs\",\"sr_BA_#Latn\",\"el\",\"uk_UA\",\"hu\",\"fr_CH\",\"in\",\"es_AR\",\"ar_EG\",\"ja_JP_JP_#u-ca-japanese\",\"es_SV\",\"pt_BR\",\"be\",\"is_IS\",\"cs_CZ\",\"es\",\"pl_PL\",\"tr\",\"ca_ES\",\"sr_CS\",\"ms_MY\",\"hr\",\"lt\",\"es_ES\",\"es_CO\",\"bg_BG\",\"sq\",\"fr\",\"ja\",\"sr_BA\",\"is\",\"es_PY\",\"de\",\"es_EC\",\"es_US\",\"ar_SD\",\"en\",\"ro_RO\",\"en_PH\",\"ca\",\"ar_TN\",\"sr_ME_#Latn\",\"es_GT\",\"sl\",\"ko_KR\",\"el_CY\",\"es_MX\",\"ru_RU\",\"es_HN\",\"zh_HK\",\"no_NO_NY\",\"hu_HU\",\"th_TH\",\"ar_IQ\",\"es_CL\",\"fi\",\"ar_MA\",\"ga_IE\",\"mk\",\"tr_TR\",\"et_EE\",\"ar_QA\",\"sr__#Latn\",\"pt_PT\",\"fr_LU\",\"ar_OM\",\"th\",\"sq_AL\",\"es_DO\",\"es_CU\",\"ar\",\"ru\",\"en_NZ\",\"sr_RS\",\"de_CH\",\"es_UY\",\"ms\",\"el_GR\",\"iw_IL\",\"en_ZA\",\"th_TH_TH_#u-nu-thai\",\"hi\",\"fr_FR\",\"de_AT\",\"nl\",\"no_NO\",\"en_AU\",\"vi\",\"nl_NL\",\"fr_CA\",\"lv_LV\",\"de_LU\",\"es_CR\",\"ar_KW\",\"sr\",\"ar_LY\",\"mt\",\"it_CH\",\"da\",\"de_DE\",\"ar_DZ\",\"sk_SK\",\"lt_LT\",\"it_IT\",\"en_IE\",\"zh_SG\",\"ro\",\"en_CA\",\"nl_BE\",\"no\",\"pl\",\"zh_CN\",\"ja_JP\",\"de_GR\",\"sr_RS_#Latn\",\"iw\",\"en_IN\",\"ar_LB\",\"es_NI\",\"zh\",\"mk_MK\",\"be_BY\",\"sl_SI\",\"es_PE\",\"in_ID\",\"en_GB\"]");

        assertEquals("Should be the same array", expected.toString(), j.toString());
    }
}