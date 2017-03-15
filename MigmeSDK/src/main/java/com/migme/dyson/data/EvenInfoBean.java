package com.migme.dyson.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by teddylin on 03/03/2017.
 */
public class EvenInfoBean {
    /**
     * action : {"type":"topup","value":1234,"description":"Topup 1234 MGC","customizedString":"","customizedStringarray":["AA","BB","CC"],"customizedInt":1324}
     */
    @SerializedName("action")
    private ActionBean action = new ActionBean();

    public ActionBean getAction() {
        return action;
    }

    public void setAction(ActionBean action) {
        this.action = action;
    }

    public static class ActionBean {
        /**
         * type : topup
         * value : 1234
         * description : Topup 1234 MGC
         * customizedString :
         * customizedStringarray : ["AA","BB","CC"]
         * customizedInt : 1324
         */
        @SerializedName("type")
        private String type;
        @SerializedName("value")
        private int value;
        @SerializedName("description")
        private String description;
        @SerializedName("customized_string")
        private String customizedString;
        @SerializedName("customized_int")
        private int customizedInt;
        @SerializedName("customized_stringarray")
        private List<String> customizedStringarray;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCustomizedString() {
            return customizedString;
        }

        public void setCustomizedString(String customizedString) {
            this.customizedString = customizedString;
        }

        public int getCustomizedInt() {
            return customizedInt;
        }

        public void setCustomizedInt(int customizedInt) {
            this.customizedInt = customizedInt;
        }

        public List<String> getCustomizedStringarray() {
            return customizedStringarray;
        }

        public void setCustomizedStringarray(List<String> customizedStringarray) {
            this.customizedStringarray = customizedStringarray;
        }
    }
}
