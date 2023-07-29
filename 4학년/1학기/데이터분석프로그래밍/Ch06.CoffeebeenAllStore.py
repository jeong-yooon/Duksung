from selenium import webdriver
import time

driver = webdriver.Chrome('chromedriver.exe')

driver.maximize_window()
driver.implicitly_wait(10)

url = 'https://www.coffeebeankorea.com/store/store.asp'

driver.get(url)



region_srh = driver.find_element_by_css_selector('.region_srh')
region_srh.click()

time.sleep(0.2)
driver.find_element_by_css_selector('#localTitle').click()

time.sleep(0.2)
storeLocal_list = driver.find_elements_by_css_selector('#storeLocal > li')

time.sleep(0.2)
driver.find_element_by_css_selector('#localTitle').click()



for storelocal in storeLocal_list:
    time.sleep(0.2)
    driver.find_element_by_css_selector('#localTitle').click()
    time.sleep(0.2)
    storelocal.click()   # 시/도 중 하나 선택 완료
    #################################################
    time.sleep(0.2)
    driver.find_element_by_css_selector('#localTitle2').click()
    #print('---------------------------')
    storeLocal2_list = driver.find_elements_by_css_selector('#storeLocal2 > li')
    #print(len(storeLocal2_list))
    time.sleep(0.2)
    driver.find_element_by_css_selector('#localTitle2').click()

    for storeLocal2 in storeLocal2_list:
        time.sleep(0.2)
        driver.find_element_by_css_selector('#localTitle2').click()
        time.sleep(0.2)
        storeLocal2.click()

        time.sleep(0.3)
        storeListUL = driver.find_elements_by_css_selector('#storeListUL > li')

        print('-----------------------------------------------')
        for store_info in storeListUL:
            store_name = store_info.find_element_by_css_selector('div.store_txt > p.name > span').text
            store_addr = store_info.find_element_by_css_selector('div.store_txt > p.address > span').text
            store_tel = store_info.find_element_by_css_selector('div.store_txt > p.tel > a').text
            print(store_name, store_addr, store_tel)

















