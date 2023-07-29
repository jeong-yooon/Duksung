from selenium import webdriver
import time

results = []  # 매장 검색 결과를 저장할 LIST

#####################################################################################
# 크롤링 수행 전 본인 컴퓨터의 화면 해상도 조절하여 웹브라우져 내용이 가급적 다 표시되도록 할 것
#####################################################################################
driver = webdriver.Chrome('chromedriver.exe')
driver.maximize_window()    #크롬브라우저 최대화
#driver.minimize_window()    #크롬브라우저 최소화 : 마우스 움직임 또는 클릭 이벤트 방해받지 않으려면 최소화 호출하세요.

driver.implicitly_wait(3)   #특정 태그 검색 시 발견되지 않으면 발견될 때 까지 지정된 second 내에서 기다리기
url = 'https://www.coffeebeankorea.com/store/store.asp' #coffebean 홈페이지 메뉴에서 'STORE' > '매장찾기' 클릭한 URL로 접속
driver.get(url)

# 지역검색 버튼 클릭
region_srh = driver.find_element_by_css_selector('.region_srh')
region_srh.click()

#해당 url page loading시 시/도 list는 이미 지정되어 있음.
#이미 HTML상에 있는 정보라 클릭하여 몇 개의 시/도가 있는지 알아올 필요없이 직접 가져오면 됨.
storeLocal_list = driver.find_elements_by_css_selector('#storeLocal > li')


for storelocal in storeLocal_list:   # 모든 시/도 선택
    driver.find_element_by_css_selector('#localTitle').click() # 시/도 select box 선택()
    storelocal.click()   # 시/도 중 하나 선택 완료
    time.sleep(0.3)      # 클릭 후 시/도에 포함되는 구/군 리스트가 생신될 때 까지 잠시 기다려야함.
                         # 구/군 select box도 갱신되길 잠시 기다림.
    storeLocal2_list = driver.find_elements_by_css_selector('#storeLocal2 > li') # 해당 시/도에 대한 구/군 list를 획득

    for storeLocal2 in storeLocal2_list:
        driver.find_element_by_css_selector('#localTitle2').click()
        storeLocal2.click()
        time.sleep(0.3) # 매장 정보를 담고 있는 li tag 부분이 갱신될 때 까지 잠시 기다려야함.
        storeTxt_list = driver.find_elements_by_css_selector('#storeListUL > li > div.store_txt')

        for store_info in storeTxt_list:
            store_name_E = store_info.find_element_by_css_selector('p.name > span')
            store_name = store_name_E.text
            store_addr_E = store_info.find_element_by_css_selector('p.address > span')
            store_addr = store_addr_E.text
            store_tel_E = store_info.find_element_by_css_selector('p.tel > a')
            store_tel = store_tel_E.text

            print(store_name, store_addr, store_tel)
            results.append([store_name, store_addr, store_tel])

print(len(results))