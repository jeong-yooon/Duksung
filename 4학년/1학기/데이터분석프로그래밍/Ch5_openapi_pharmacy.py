

import json
import pandas as pd
import requests
import xmltodict
from pandas.io.json import json_normalize






# [CODE 0]
def main():
    jsonResult = []
    result = []
    natName = ''
    print("<< 약국을 검색합니다.. >>")
    emdongNm = input('동이름을 입력하세요 : ')

    #service_key = 'nq/q4wc9ixxo+kc2gpyllrM6Gx21gS5iW8TlZ/gznA+d9y5BDtoTWNcz4d6VBmplyAhPNHIKYBTLc7h3M0Ye4A=='
    service_key = 'nq%2Fq4wc9ixxo%2Bkc2gpyllrM6Gx21gS5iW8TlZ%2FgznA%2Bd9y5BDtoTWNcz4d6VBmplyAhPNHIKYBTLc7h3M0Ye4A%3D%3D'
    service_key = requests.utils.unquote(service_key)
    url = 'http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList'
    params = {'serviceKey': service_key, 'pageNo': '1', 'numOfRows': '10',
              'emdongNm': emdongNm}


    try:
        response = requests.get(url, params=params)
        if (response.status_code == 200):
            print('response 200 OK')
            contents = response.text
            xml_parse = xmltodict.parse(contents)  # string인 xml 파싱
            xml_dict = json.loads(json.dumps(xml_parse, sort_keys=True))
            get_info = xml_dict['response']['body']['items']['item']
            df = pd.DataFrame(get_info)
            print(df)
            print('----------------------------')
            df1  = json_normalize(get_info)
            print(df1)


            df.to_csv('{}_openapi_pharmacy.csv'.format(emdongNm), index=False, encoding='utf-8')
    except Exception as e:
        print(e)
        print("Error for", response)
        return None


if __name__ == '__main__':
    main()


