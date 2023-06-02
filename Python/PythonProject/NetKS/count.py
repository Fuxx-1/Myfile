import pyshark
ipA, ipB, ipC = "192.168.128.1", "192.168.128.128", "192.168.128.48"
i, j, k = 0, 0, 0
capture = pyshark.FileCapture("./net.pcapng")
print(capture[0].ip)
for packet in capture:
    if packet.ip.proto == 6 and packet.ip.source == ipA and packet.ip.destination == ipB or ipC:
        print(packet.ip.proto)