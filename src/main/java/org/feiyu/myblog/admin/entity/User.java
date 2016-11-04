package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/22.
 */

/**
 * @author feiyu
 * @version 1.0
 * @itle: User
 * @description 用户试题类
 * @create 2016/10/22
 */
public class User {

    /**用户id**/
    private String id;
    /**用户名**/
    private String userName;
    /**用户密码**/
    private String password;
    /**email**/
    private String email;
    /**头像url**/
    private String imageUrl;
    /**现居地**/
    private String presentAddress;
    /**教育程度**/
    private String diploma;
    /**个人标签**/
    private String labels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public User(){}

    public User(String id, String userName, String password, String email, String imageUrl,
                String presentAddress, String diploma, String labels) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
        this.presentAddress = presentAddress;
        this.diploma = diploma;
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", diploma='" + diploma + '\'' +
                ", labels='" + labels + '\'' +
                '}';
    }
}
