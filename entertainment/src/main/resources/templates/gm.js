var map;
var button = document.getElementById('map_button');
button.addEventListener('click', changeCenter);

function initMap() {
    var gyeongbokgung = { lat: 37.57979553563185, lng: 126.97706245552442 };
    map = new google.maps.Map( document.getElementById('map'), {
        zoom: 15,
        center: gyeongbokgung
    });

    var mainMarker = new google.maps.Marker({
        position: gyeongbokgung,
        map: map,
        label: {
            text: "경복궁",
            color: "#C70E20"
        },
        icon: {
            url: "pooh_marker.png",
            labelOrigin: new google.maps.Point(100, 55)
        }
    });

    var subMarkerPoint = { lat: 37.57956596361732, lng: 126.9803240214433};
    var subMarker = new google.maps.Marker({
        position: subMarkerPoint,
        map: map,
        label: "국립현대미술관",
        icon: {
            url: "http://maps.google.com/mapfiles/ms/icons/red-dot.png",
            labelOrigin: new google.maps.Point(20, 47),
            anchor: new google.maps.Point(50,32)
        }
    });
}

function changeCenter() {
    var gyeongbokgung = { lat: 37.57979553563185, lng: 126.97706245552442 };
    map.panTo(gyeongbokgung);
    map.setZoom(15);
}