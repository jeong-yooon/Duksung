import os
import sys
import urllib.request
import datetime
import time
import json
import requests
import xmltodict
import pandas as pd

client_id = '0zZLn9e5MpW6gAOjflJ8'
client_secret = 'QGEoijj_sl'





#[CODE 1]


def getReeustUrl_by_requests(url, search_keyword, start, display):
    params = {'query': search_keyword, 'start': start, 'display': display }
    headers = {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret':client_secret}

    try:
        response = requests.get(url, params=params, headers=headers)
        if (response.status_code == 200):
            print('response 200 OK')
            contents = response.text
            return contents

    except Exception as e:
        print(e)
        print("Error for", response)
        return None


def getRequestUrl(url):    
    req = urllib.request.Request(url)
    req.add_header("X-Naver-Client-Id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    
    try: 
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print ("[%s] Url Request Success" % datetime.datetime.now())
            #return response.read().decode('utf-8')
            return response.read()

    except Exception as e:
        print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None

#[CODE 2]
def getNaverSearch(node, srcText, start, display):    
    base = "https://openapi.naver.com/v1/search"
    node = "/%s.json" % node
    parameters = "?query=%s&start=%s&display=%s" % (urllib.parse.quote(srcText), start, display)
    
    #url = base + node + parameters
    #responseDecode = getRequestUrl(url)   #[CODE 1]

    url = base + node
    responseDecode = getReeustUrl_by_requests(url, srcText, start, display)
    if (responseDecode == None):
        return None
    else:
        return json.loads(responseDecode)

#[CODE 3]
def getPostData(post, jsonResult, cnt):    
    title = post['title']
    description = post['description']
    org_link = post['originallink']
    link = post['link']
    
    pDate = datetime.datetime.strptime(post['pubDate'],  '%a, %d %b %Y %H:%M:%S +0900')
    pDate = pDate.strftime('%Y-%m-%d %H:%M:%S')
    
    jsonResult.append({'cnt':cnt, 'title':title, 'description': description, 'org_link':org_link,
                       'link': org_link,   'pDate':pDate})
    return    

#[CODE 0]
def main():
    node = 'news'   # 크롤링 할 대상
    srcText = input('검색어를 입력하세요: ')
    cnt = 0
    jsonResult = []

    jsonResponse = getNaverSearch(node, srcText, 1, 100)  #[CODE 2]
    total = jsonResponse['total']


    with open('%s_jsonResponse_%s.json' % (srcText, node), 'w', encoding='utf8') as outfile:
        jsonFile = json.dumps(jsonResponse, indent=4, sort_keys=True, ensure_ascii=False)

        outfile.write(jsonFile)
 
    while ((jsonResponse != None) and (jsonResponse['display'] != 0)):         
        for post in jsonResponse['items']:
            cnt += 1
            getPostData(post, jsonResult, cnt)  #[CODE 3]       
        
        start = jsonResponse['start'] + jsonResponse['display']
        jsonResponse = getNaverSearch(node, srcText, start, 100)  #[CODE 2]
       
    print('전체 검색 : %d 건' %total)
    
    with open('%s_naver_%s.json' % (srcText, node), 'w', encoding='utf8') as outfile:
        jsonFile = json.dumps(jsonResult,  indent=4, sort_keys=True,  ensure_ascii=False)
                        
        outfile.write(jsonFile)
        
    print("가져온 데이터 : %d 건" %(cnt))
    print ('%s_naver_%s.json SAVED' % (srcText, node))




    
if __name__ == '__main__':
    main()
