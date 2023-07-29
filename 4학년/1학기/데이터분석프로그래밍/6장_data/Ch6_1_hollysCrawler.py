from bs4 import BeautifulSoup
import urllib.request
import pandas as pd
import requests
import datetime

#[CODE 1]
def hollys_store(result):
    result_test = []
    for page in range(1,55):
        Hollys_url = f'https://www.hollys.co.kr/store/korea/korStore2.do?pageNo={page}&sido=&gugun=&store='
        print(Hollys_url)
        #html = urllib.request.urlopen(Hollys_url)
        #html = urllib.request.urlopen(Hollys_url).read()

        response =  requests.get(Hollys_url)

        if(response.status_code == 200):
            html = response.content
            soupHollys = BeautifulSoup(html, 'html.parser')
            tag_tbody = soupHollys.find('tbody')
            for store in tag_tbody.find_all('tr'):
                store_td = store.find_all('td')
                store_name = store_td[1].string
                store_sido = store_td[0].string
                store_address = store_td[3].string
                store_phone = store_td[5].string
                result.append([store_name] + [store_sido] + [store_address] + [store_phone])
                result_test.append([store_name, store_sido, store_address, store_phone])
        """    
        soupHollys = BeautifulSoup(html, 'html.parser')
        tag_tbody = soupHollys.find('tbody')
        for store in tag_tbody.find_all('tr'):
            store_td = store.find_all('td')
            store_name = store_td[1].string
            store_sido = store_td[0].string
            store_address = store_td[3].string
            store_phone = store_td[5].string
            result.append([store_name]+[store_sido]+[store_address]+[store_phone])
            result_test.append([store_name, store_sido, store_address, store_phone])
        """

    return

#[CODE 0]
def main():
    result = []

    print('Hollys store crawling >>>>>>>>>>>>>>>>>>>>>>>>>>')
    hollys_store(result)   #[CODE 1] 호출 
    hollys_tbl = pd.DataFrame(result, columns=('store', 'sido-gu', 'address','phone'))
    hollys_tbl.to_csv('hollys.csv', encoding='cp949', mode='w', index=True)

       
if __name__ == '__main__':
     main()

