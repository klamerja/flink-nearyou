import {Kafka, Partitioners} from "kafkajs";

const kafka = new Kafka({
    clientId: "lidl",
    brokers: ["localhost:9094"],
});

const producer = kafka.producer({
    createPartitioner: Partitioners.DefaultPartitioner
});

const message = [];
for (let i = 0; i < 1; i++) {
    message.push({value: JSON.stringify({rent_id: 1, latitude: 78.5, longitude: 78.5})})
}
await producer.connect();
await producer.send({
    topic: "test",
    messages: message
});

await producer.disconnect();
