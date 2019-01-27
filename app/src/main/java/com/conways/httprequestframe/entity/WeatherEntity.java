package com.conways.httprequestframe.entity;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public class WeatherEntity {

    /**
     * {
     * 	"weatherinfo": {
     * 		"city": "瑗垮畨",
     * 		"cityid": "101110101",
     * 		"temp": "23.3",
     * 		"WD": "瑗垮崡椋�",
     * 		"WS": "灏忎簬3绾�",
     * 		"SD": "52%",
     * 		"AP": "962.7hPa",
     * 		"njd": "鏆傛棤瀹炲喌",
     * 		"WSE": "<3",
     * 		"time": "18:00",
     * 		"sm": "1.2",
     * 		"isRadar": "1",
     * 		"Radar": "JC_RADAR_AZ9290_JB"
     *        }
     * }
     */

    private Weather weatherinfo;

    public Weather getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weather weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public class Weather{
        private String city;
        private String cityid;
        private String temp;
        private String WD;
        private String WS;
        private String SD;
        private String AP;
        private String njd;
        private String time;
        private String sm;
        private String isRadar;
        private String Radar;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getAP() {
            return AP;
        }

        public void setAP(String AP) {
            this.AP = AP;
        }

        public String getNjd() {
            return njd;
        }

        public void setNjd(String njd) {
            this.njd = njd;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSm() {
            return sm;
        }

        public void setSm(String sm) {
            this.sm = sm;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public String getRadar() {
            return Radar;
        }

        public void setRadar(String radar) {
            Radar = radar;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "city='" + city + '\'' +
                    ", cityid='" + cityid + '\'' +
                    ", temp='" + temp + '\'' +
                    ", WD='" + WD + '\'' +
                    ", WS='" + WS + '\'' +
                    ", SD='" + SD + '\'' +
                    ", AP='" + AP + '\'' +
                    ", njd='" + njd + '\'' +
                    ", time='" + time + '\'' +
                    ", sm='" + sm + '\'' +
                    ", isRadar='" + isRadar + '\'' +
                    ", Radar='" + Radar + '\'' +
                    '}';
        }
    }
}
