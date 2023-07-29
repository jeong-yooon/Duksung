import folium
import urllib.request
import json
import pandas as pd


def Call_naver_map_api(store_addr):
    client_id = '8lnyeqij6k'
    client_secret = '9QIVVXRAIdOMl8oUw93DoedB1Tz2olrC7zLFjNG'
    encText = urllib.parse.quote(store_addr)
    url = 'https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query='+encText
    request = urllib.request.Request(url)
    request.add_header('X-NCP-APIGW-API-KEY-ID', client_id)
    request.add_header('X-NCP-APIGW-API-KEY', client_secret)
    response = urllib.request.urlopen(request)
    rescode = response.getcode()
    if(rescode == 200):
        reponse_body = response.read()
        #print(reponse_body.decode('utf-8'))
        return reponse_body.decode('utf-8')

def Get_StoreAddr_GPS_Pos(store_addr):
    jsonResponse = json.loads(Call_naver_map_api(store_addr))
    gps_x = 0
    gps_y = 0
    if jsonResponse['meta']['totalCount'] != 0:
        gps_x = jsonResponse['addresses'][0]['x']
        gps_y = jsonResponse['addresses'][0]['y']
        #print(gps_x, gps_y)
    else:
        print('Cannot get pos following address: ', store_addr)

    return gps_x, gps_y




CB = pd.read_csv('./CoffeeBean.csv', encoding = 'CP949', index_col = 0, header = 0,
                     engine = 'python')

CB[['x']] = 0.0
CB[['y']] = 0.0
print(CB)


for index, row in CB.iterrows():
    print(index, row['address'], type(row['address']))
    pos_x, pos_y = Get_StoreAddr_GPS_Pos(row['address'])
    CB.at[index,'x'] = float(pos_x)
    CB.at[index,'y'] = float(pos_y)
print(CB)
CB.to_csv('coffebean_gps_pos.csv', encoding='CP949', index = False)
"""
for store_addr in addr_list:

    jsonResponse = json.loads(search_map(store_addr))
    if jsonResponse['meta']['totalCount'] != 0:
        gps_x = jsonResponse['addresses'][0]['x']
        gps_y = jsonResponse['addresses'][0]['y']
        #print(gps_x, gps_y)
    else:
        print(store_addr)

"""
import folium
map_CB = folium.Map(location = [37.560284, 126.975334], zoom_start = 15)
for i, store in CB.iterrows():
    if store['x'] != 0:
        folium.Marker(location = [store['y'], store['x']], popup =
                        store['store'], icon = folium.Icon(color = 'red',
                        icon = 'star')).add_to(map_CB)

map_CB.save('map_CB.html')


import webbrowser
webbrowser.open('map_CB.html')
