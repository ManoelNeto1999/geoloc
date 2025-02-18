import React, { useState } from 'react';
import {
  GoogleMap,
  LoadScript,
  Marker,
  InfoWindow,
} from '@react-google-maps/api';
import { MarkerData } from './types/maps';



const MapComponent: React.FC = () => {
  const [markers, setMarkers] = useState<MarkerData[]>([]);
  const [selectedMarker, setSelectedMarker] = useState<MarkerData | null>(null);
  const [hoveredMarker, setHoveredMarker] = useState<MarkerData | null>(null);
  const [searchLocation, setSearchLocation] = useState<string>('');
   const [hoverTimeout, setHoverTimeout] = useState<NodeJS.Timeout | null>(
     null
   );
  const [center, setCenter] = useState<{ lat: number; lng: number }>({
    lat: -23.5505,
    lng: -46.6333,
  });

  const handleMapClick = (event: any) => {
    clearInput();

    const lat = event.latLng.lat();
    const lng = event.latLng.lng();

    const newMarker: MarkerData = {
      id: markers.length + 1,
      position: { lat, lng },
      problem: '',
    };

    setMarkers((prev) => [...prev, newMarker]);
    console.log('New marker added:', newMarker);

    // Faz a geocodificação reversa
    const geocoder = new google.maps.Geocoder();
    geocoder.geocode({ location: { lat, lng } }, (results, status) => {
      if (status === 'OK' && results && results[0]) {
        console.log(results)
        const address = results[0].formatted_address;
        console.log('Endereço encontrado:', address);

        setMarkers((prevMarkers) =>
          prevMarkers.map((m) =>
            m.id === newMarker.id ? { ...m, address } : m
          )
        );
      } else {
        console.error('Geocoding falhou:', status);
      }
    });
  };

  const clearInput = () => {
    // setSelectedMarker(null);
  };

  const handleSearch = () => {
    const geocoder = new google.maps.Geocoder();
    geocoder.geocode({ address: searchLocation }, (results, status) => {
      if (status === 'OK' && results) {
        const location = results[0].geometry.location;
        setCenter({ lat: location.lat(), lng: location.lng() });
        setSearchLocation(''); // Limpa a barra de pesquisa após a busca
      } else {
        alert('Localização não encontrada. Tente novamente.');
      }
    });
  };



  const handleMouseOver = (position: MarkerData) => {
    if (hoverTimeout) {
      clearTimeout(hoverTimeout);
    }
    setHoveredMarker(position);
  };
   const handleMouseOut = () => {
     const timeout = setTimeout(() => {
       setHoveredMarker(null);
     }, 1000); 
     setHoverTimeout(timeout);
   };

     const handleInfoWindowMouseOver = () => {
       if (hoverTimeout) {
         clearTimeout(hoverTimeout); 
       }
     };

  return (
    <LoadScript googleMapsApiKey="AIzaSyC2A2HFEoS4YWxI8tMVNzz2j8-RtlQO_1I">
      <div style={styles.searchContainer}>
        <input
          type="text"
          value={searchLocation}
          onChange={(e) => setSearchLocation(e.target.value)}
          placeholder="Buscar local"
          style={styles.searchInput}
        />
        <button onClick={handleSearch} style={styles.searchButton}>
          Buscar
        </button>
      </div>
      <GoogleMap
        onClick={handleMapClick}
        mapContainerStyle={styles.mapContainer}
        center={center}
        zoom={17}
      >
        {markers.map((marker) => (
          <Marker
            key={marker.id}
            position={marker.position}
            onClick={() => setSelectedMarker(marker)}
            onMouseOver={() => handleMouseOver(marker)}
            onMouseOut={() => handleMouseOut()}
            icon={{
              url: "https://maps.google.com/mapfiles/ms/icons/blue-dot.png", // Estilo personalizado para o marcador
            }}
          />
        ))}

        {selectedMarker && (
          <InfoWindow
            position={selectedMarker.position}
            onCloseClick={() => setSelectedMarker(null)}
          >
            <div style={styles.infoWindow}>
              <h3 style={styles.infoWindowTitle}>Detalhes do Local</h3>
              <p>{selectedMarker.address || "Endereço não encontrado"}</p>
              <h3 style={styles.infoWindowTitle}>Problema</h3>
              <input
                type="text"
                placeholder="Descreva o problema"
                value={selectedMarker.problem}
                onChange={(e) => {
                  const updatedMarkers = markers.map((m) =>
                    m.id === selectedMarker.id
                      ? { ...m, problem: e.target.value }
                      : m
                  );
                  setMarkers(updatedMarkers);
                }}
                style={styles.infoWindowInput}
              />
            </div>
          </InfoWindow>
        )}

        {hoveredMarker && (
          <InfoWindow position={hoveredMarker.position}>
            <div
              onMouseOver={handleInfoWindowMouseOver}
              onMouseOut={() => handleMouseOut()}
            >
              {/* Adicionar componente aq  */}
              <div style={styles.infoWindow}>
                <h3 style={styles.infoWindowTitle}>Detalhes</h3>
                <p>{hoveredMarker.address || "Endereço não encontrado"}</p>
                <p style={styles.infoWindowText}>
                  {hoveredMarker.problem || "Sem descrição"}
                </p>
              </div>
            </div>
          </InfoWindow>
        )}
      </GoogleMap>
    </LoadScript>
  );
};

// Estilos CSS em JS
const styles = {
  searchContainer: {
    display: 'flex',
    justifyContent: 'center',
    marginBottom: '10px',
  },
  searchInput: {
    padding: '10px',
    fontSize: '16px',
    borderRadius: '4px',
    border: '1px solid #ccc',
    width: '300px',
    marginRight: '10px',
  },
  searchButton: {
    padding: '10px 20px',
    fontSize: '16px',
    borderRadius: '4px',
    backgroundColor: '#007bff',
    color: '#fff',
    border: 'none',
    cursor: 'pointer',
  },
  mapContainer: {
    height: '600px',
    width: '100%',
  },
  infoWindow: {
    maxWidth: '200px',
    padding: '10px',
    fontSize: '14px',
    color: '#333',
  },
  infoWindowTitle: {
    fontSize: '16px',
    fontWeight: 'bold',
    marginBottom: '5px',
  },
  infoWindowText: {
    fontSize: '14px',
  },
  infoWindowInput: {
    width: '100%',
    padding: '5px',
    fontSize: '14px',
    border: '1px solid #ccc',
    borderRadius: '4px',
  },
};

export default MapComponent;
