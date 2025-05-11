package at.tuwien.swtesting.pageobjects;

import com.microsoft.playwright.Page;


public class OwnerPage {
    protected Page page;

    public OwnerPage(Page page) {
        this.page = page;
    }


    public String getName() {
        return page.textContent("#name");
    }

    public String getAddress () {
        return page.textContent("#address");
    }
    public String getCity () {
        return page.textContent("#city");
    }
    public String getTelephone() {
        return page.textContent("#telephone");
    }


    public String getHeading() {
        return page.textContent("h2");
    }

    public void clickEditOwner() {
        page.click("text=Edit Owner");
    }


}
