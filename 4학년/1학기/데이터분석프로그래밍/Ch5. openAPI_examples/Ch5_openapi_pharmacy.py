

import json
import pandas as pd
import requests
import xmltodict





# [CODE 0]
def main():
    jsonResult = []
    result = []
    natName = ''
    print("<< 약국을 검색합니다.. >>")
    emdongNm = input('동이름을 입력하세요 : ')

    service_key = 'nq/q4wc9ixxo+kc2gpyllrM6Gx21gS5iW8TlZ/gznA+d9y5BDtoTWNcz4d6VBmplyAhPNHIKYBTLc7h3M0Ye4A=='

    url = 'http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList'
    params = {'serviceKey': service_key, 'pageNo': '1', 'numOfRows': '10',
              'emdongNm': emdongNm}

    response = requests.get(url, params=params)

    if(response.status_code == 200):
        contents = response.text

        xml_parse = xmltodict.parse(contents)  # string인 xml 파싱
        xml_dict = json.loads(json.dumps(xml_parse, sort_keys=True))

        get_info = xml_dict['response']['body']['items']['item']

        df = pd.DataFrame(get_info)

        df.to_csv('openapi_pharmacy.csv', index=False, encoding='cp949')


if __name__ == '__main__':
    main()


