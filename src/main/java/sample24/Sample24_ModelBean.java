package sample24;

public class Sample24_ModelBean {

    private String param;

    /**
     * @return param
     */
    public String getParam() {
        return "".equals(param) ? "空白":param;
    }

    /**
     * @param param セットする param
     */
    public void setParam(String param) {
        this.param = param;
    }
}
