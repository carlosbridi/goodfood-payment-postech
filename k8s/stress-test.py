import requests
import concurrent.futures

# URL and headers for the GET request
url = 'http://10.110.172.60:8080/produto?categoria=LANCHE'
headers = {
    'accept': '*/*'
}

# Function to send a single GET request
def send_get_request():
    response = requests.get(url, headers=headers)
    return response.status_code

# Function to send 1000 GET requests
def send_requests_concurrently():
    with concurrent.futures.ThreadPoolExecutor(max_workers=50) as executor:
        futures = [executor.submit(send_get_request) for _ in range(10000)]
        for future in concurrent.futures.as_completed(futures):
            status_code = future.result()
            print(f'Status Code: {status_code}')

if __name__ == '__main__':
    send_requests_concurrently()
