import React, { useEffect } from "react";

export default function Map(props) {
  useEffect(() => {
    const initMap = () => {
      const map = new window.google.maps.Map(document.getElementById("map"), {
        center: { lat: 37.5986511, lng: 127.0150691 },
        zoom: 14,
      });

      const malls = [
        {
          label: "우리집",
          name: "코엑스몰",
          lat: 37.5986511,
          lng: 127.0150691,
        },
        { label: "수업", name: "고투몰", lat: 37.6010173, lng: 127.0158196 },
      ];

      const bounds = new window.google.maps.LatLngBounds();
      const infoWindow = new window.google.maps.InfoWindow();

      malls.forEach(({ label, name, lat, lng }) => {
        const marker = new window.google.maps.Marker({
          position: { lat, lng },
          label,
          map,
        });
        bounds.extend(marker.position);

        marker.addListener("click", () => {
          map.panTo(marker.position);
          infoWindow.setContent(name);
          infoWindow.open({
            anchor: marker,
            map,
          });
        });
      });

      map.fitBounds(bounds);
    };

    if (!window.google) {
      const script = document.createElement("script");
      script.defer = true;
      script.src = `https://maps.googleapis.com/maps/api/js?key=AIzaSyADDl-QllKjZzGT5rz7sVdkNU9mExb9vXQ&callback=initMap&region=kr`;
      script.onload = () => initMap();
      document.head.appendChild(script);
    } else {
      initMap();
    }
  }, []);

  return (
    <div>
      <div id="map" style={{ height: "500px" }}></div>
    </div>
  );
}
