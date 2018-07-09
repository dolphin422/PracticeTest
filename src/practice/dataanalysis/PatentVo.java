package practice.dataanalysis;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/25 9:41
 */
public class PatentVo {

    private String name ;

    private String publishNum;

    private String publishDate;

    private String applicationNum;

    private String applicationDate;
    private String applicant;

    private String inventor;

    private String address;

    private String typeNum;

    private String simpleContent;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(String typeNum) {
        this.typeNum = typeNum;
    }

    public String getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(String simpleContent) {
        this.simpleContent = simpleContent;
    }

    @Override
    public String toString() {
        return "PatentVo{" +
            "name='" + name + '\'' +
            ", publishNum='" + publishNum + '\'' +
            ", publishDate='" + publishDate + '\'' +
            ", applicationNum='" + applicationNum + '\'' +
            ", applicationDate='" + applicationDate + '\'' +
            ", applicant='" + applicant + '\'' +
            ", inventor='" + inventor + '\'' +
            ", address='" + address + '\'' +
            ", typeNum='" + typeNum + '\'' +
            ", simpleContent='" + simpleContent + '\'' +
            '}';
    }
}
