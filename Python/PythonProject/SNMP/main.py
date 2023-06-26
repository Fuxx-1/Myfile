import snmpy

# 配置 SNMP 设置
ip_address = 'localhost'
community = 'public'
version = 'v2c'  # 使用 SNMPv2c
session = snmpy.Session(ip_address, community, version)

# 发送 SNMP 请求
oid = '1.3.6.1.2.1.1.1.0'  # 系统描述
result = session.get(oid)

# 处理响应数据
if result.error:
    print(f"Error: {result.error}")
else:
    print(f"{oid} = {result.value}")