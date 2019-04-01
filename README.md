# PersonalProject CMPE 281
### Mongo DB Cluster Architecture Diagram

![Mongo DB Cluster Architecture Diagram](https://github.com/nguyensjsu/cmpe281-RAVITEJAKOMMALAPATI20/blob/master/PersonalProject/MongoDB/ArchitectureDiagrams/MongoDB%20Architecture%20Diagram.jpeg)

### MongoDB ReplicaSet

![MongoDB ReplicaSet](https://github.com/nguyensjsu/cmpe281-RAVITEJAKOMMALAPATI20/blob/master/PersonalProject/MongoDB/ArchitectureDiagrams/MongoDB%20ReplicaSet.png)

### MongoDB Single Master
![MongoDB Single Master](https://github.com/nguyensjsu/cmpe281-RAVITEJAKOMMALAPATI20/blob/master/PersonalProject/MongoDB/ArchitectureDiagrams/MongoDBSingleMasterDiagram.jpeg)


### create a replecaset with 5 mogoDB instances
#### SSH into instances
```
ssh -i "cmpe281uswest2.pem" ubuntu@10.0.1.47
ssh -i "cmpe281uswest2.pem" ubuntu@10.0.4.170
ssh -i "cmpe281uswest2.pem" ubuntu@10.0.3.216
ssh -i "cmpe281uswest2.pem" ubuntu@10.0.3.97
ssh -i "cmpe281uswest2.pem" ubuntu@10.0.4.73
```
```
Using mongo-ami, launch three free tier instances with their own Elastic IPs.
Edit /etc/hosts in each EC2 Instance adding local host names for Public IPs.
For example:
sudo nano /etc/hosts
10.0.1.47    Primary
10.0.4.170   MongoDb-secondary1
10.0.3.216   MongoDB-secondary2
10.0.3.97    MongoDB-secondary3
10.0.4.73    MongoDB-secondary4
```
### Initialize the Replica Set
```
mongo
rs.initiate( {
       _id : "cmpe281",
       members: [
          { _id: 0, host: " Primary:27017" },
          { _id: 1, host: " MongoDb-secondary1:27017" },
          { _id: 2, host: " MongoDB-secondary2:27017"},
	  { _id: 3, host: " MongoDB-secondary3:27017"  },
         { _id: 4, host: " MongoDB-secondary4:27017"}
       ]
    })

rs.status()
sudo service mongod restart
sudo service mongod status
```

### Links to an external site.Create Admin Account

```
mongo
use admin

db.createUser( {
        user: "admin",
        pwd: "*****",
        roles: [{ role: "root", db: "admin" }]
    });

    exit

   Syntax=> mongo -u <user> -p <password> --authenticationDatabase admin
   
   mongo -u "admin" -p "password"  --authenticationDatabase admin

Login to Mongo Remote
   mongo -u <user> -p <password> <mongo host ip> --authenticationDatabase admin
```
### Adjust Priority for Replica Set Member(Optional)
```
cfg = rs.conf()
cfg.members[0].priority = 1
cfg.members[1].priority = 0.5
cfg.members[2].priority = 0.5
cfg.members[3].priority = 0.8
cfg.members[4].priority = 0.7
rs.reconfig(cfg)
```
### Steps for testing Partition Tolerance

### Enter into MongoDB console
```
mongo -u "admin" -p "password"  --authenticationDatabase admin
rs.status()
use admin
rs.slaveOk()
db.getCollectionNames()
```
### Insert a record in to the Mongo DB
```
db.student.insert(
{
    "city":"Santaclara",
    "name" : {
        "first" : "Martin",
        "last" : "Odersky"
    },
    "contribs" : [
        "Scala"
    ]    
});
```
```
db.student.find()
```
### How does the system function during normal mode (i.e. no partition)
### Create partition in the MongoDB Cluster

```
sudo iptables -A INPUT -s 10.0.3.97 -j DROP
sudo iptables -A INPUT -s 10.0.4.73 -j DROP
```
```
sudo iptables -A INPUT -s 10.0.1.47 -j DROP
sudo iptables -A INPUT -s 10.0.4.170 -j DROP
sudo iptables -A INPUT -s 10.0.3.216 -j DROP
```
### Check Status once system in partition

```
rs.status()
```
### What happens to the master node during a partition? 

### Update the existing Record
```
db.student.update({ "_id" : ObjectId("5c96e0aec101094442de562e")},{
    "city":"SanJose",
    "name" : {
        "first" : "Martin",
        "last" : "Odersky"
    },
    "contribs" : [
        "Scala"
    ]    
});
```
```
db.student.remove({});
```

### Can stale data be read from a slave node during a partition?
```
Yes We can read the stale Data when the system is in partition.
```


### Commands for Partition Recovery
```
sudo iptables -D INPUT -s 10.0.3.97 -j DROP
sudo iptables -D INPUT -s 10.0.4.73 -j DROP
```
```
sudo iptables -D INPUT -s 10.0.1.47 -j DROP
sudo iptables -D INPUT -s 10.0.4.170 -j DROP
sudo iptables -D INPUT -s 10.0.3.216 -j DROP
```

### What happens to the system during partition recovery?
```
During partition recovery updated data will be replicated to the nodes that are joined back to the Network.
And now all the nodes will be having same data
```

Hence Tested the partition Tolerance in MongoDB





